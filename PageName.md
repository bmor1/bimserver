# Introduction #

An OID (Object Identifier) is of type long, 64 bits, 8 bytes. OID's are unique within 1 BIMserver instance and incremented for each new object.

When, for example, updating an attribute of an object, there is a call which requires the OID of the object, the className (type of the object), the attribute's name and the new value. Giving the className of the object seems quite redundant because you already gave the OID. This is not the case because the BIMserver will need the className to find the right table. The objective for this small project was to try and eleminate the className variable from this and many other calls.

# Encoding #

Of the 64 bits in the OID, we can use for example 16 bits to encode the type. This will limit the amount of OID's a server can have from 2<sup>64 to 2</sup>48, but that would still be enough (281474976710656), with this we could support 2^16 (65536) different classes.

When implementing this, we came to the following limitation of the IFC STEP Physical file format: unsiged int, 32bit (max: 4294967296).

We tried encoding the type as the first 2 bytes, and also as the last 2 bytes (which significantly reduces the value of typical oids), but still number greater than 2^32 will be generated.

The ExpressID in STEP physical file format is actually only used for the internal integrety of the records in the file, and the documentation states that it may very per export of the same model. So what we could do is just normalise every export, which will also minimize the size of the actual outgoing files.

# Indexing #

We could create an index that maps from OID to type, this would cost 10 bytes per record. Costs of writing are actually the problem here, because this would double the amount of writes. Of course also the reads we go up (but not a factor 2 because most reads will still be done knowing the actual class in advance)

# One large table #

Right now all entities have their own tables. Keys are [+ oid + rid](pid.md). We could just use one table and make the keys like this: [+ cid + oid + rid](pid.md), but this way you would still need the cid (type). Another option would bd [+ oid + cid + rid](pid.md), but in this case you cannot query for all objects of a certain type in a certain project. So this is no option. Yet another option would be [+ pid + oid + rid](cid.md), but still the problem remains.

# Conclusion #

The fact that in IFC, identifiers are 32bit, makes it impossible to encode the type of an object in the oid, because the remaining amount of usable oid's would become too small. That is assuming that we want to keep the BIMserver oid's the same as the IFC-file's express ids. If the latter is not the case, we can do encoding and the best solution would be to encode the cid in the last 2 bytes of the oid.