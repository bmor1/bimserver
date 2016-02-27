
```
javax.mail.SendFailedException: Invalid Addresses (com.sun.mail.smtp.SMTPAddressFailedException: 550 5.7.1 Unable to relay
```

or

```
javax.mail.SendFailedException: Invalid Addresses (com.sun.mail.smtp.SMTPAddressFailedException: 553 5.3.0 <test@bimserver.org>... Relaying denied,Authenticate with your username and password first
```

The SMTP server is used to send e-mail, when an invalid SMTP server is set, this is the error you will get.

```
java.lang.OutOfMemoryError: GC overhead limit exceeded
```

or

```
java.lang.OutOfMemoryError: Java heap space
```

The server has run out of memory. Install more physical memory and/or assign more memory to your application server.

```
com.sleepycat.je.EnvironmentFailureException: (JE 4.1.6) JAVA_ERROR: Java Error occurred, recovery may not be possible.
```

This is a serious error, if a reboot does not work your database will probably be corrupted. A lot of times this error occurs right after memory problems

```
javax.xml.bind.UnmarshalException - with linked exception: [java.net.ConnectException: Connection timed out: connect]
```

When your server has no internet connectivity, the version information cannot be fetched online

```
java.lang.NoClassDefFoundError: Files\Apache
```

or

```
Caused by: java.lang.ClassNotFoundException: Files
```

This (and other errors containing incomplete paths) usually have to do with spaces (" ") in paths. All of these should be fixed from 1.0.1 on, so please let us know if you come across errors like this.

```
org.bimserver.ifcengine.IfcEngineException: Unknown IFC Engine error
```

Unknown error in the IFC Engine, this can be all kinds of things:
  * IFC Engine has crashed
  * Incorrect paths
  * Memory problems in the second JVM