package org.bimserver.tests;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import nl.tue.buildingsmart.express.dictionary.SchemaDefinition;

import org.bimserver.emf.IdEObject;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.SchemaLoader;
import org.bimserver.ifc.emf.Ifc2x3.IfcProject;
import org.bimserver.ifc.file.reader.IfcStepDeserializer;
import org.bimserver.ifc.file.reader.IncorrectIfcFileException;
import org.bimserver.ifc.file.writer.IfcStepSerializer;
import org.bimserver.merging.IncrementingOidProvider;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.utils.SwingUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Visualise extends JFrame {
	private static final long serialVersionUID = 9066505986920442200L;

	public static void main(String[] args) {
		SchemaDefinition schema = SchemaLoader.loadDefaultSchema();
		IfcStepDeserializer deserializer = new IfcStepDeserializer(schema);
		try {
			IfcModel model1 = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model1b = deserializer.read(TestFile.EXPORT1.getFile());
			IfcModel model2 = deserializer.read(TestFile.EXPORT3.getFile());
			IfcModel model2b = deserializer.read(TestFile.EXPORT3.getFile());
			model1.setObjectOids();
			model1b.setObjectOids();
			model2.setObjectOids();
			model2b.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModel merged = new RevisionMerger(model1, model2).merge();
			IfcStepSerializer serializer = new IfcStepSerializer(null, null, "merged", merged, schema);
			serializer.writeToFile(new File("merged.ifc"));
			new Visualise().start(model1b, "Model 1");
			new Visualise().start(model2b, "Model 2");
			new Visualise().start(merged, "Merged");
		} catch (IncorrectIfcFileException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class Model extends DefaultTreeModel {
		private static final long serialVersionUID = 8662534344492596229L;

		public Model(TreeNode root) {
			super(root);
		}
	}

	public static class LeafNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = -4778018897806257565L;

		public LeafNode(Object val) {
			super(val == null ? "" : val);
		}
	}

	public static class StructuralFeatureNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = -5928011017640377791L;
		private List<TreeNode> nodes;
		private final EStructuralFeature eStructuralFeature;
		private final IdEObject idEObject;

		public StructuralFeatureNode(IdEObject idEObject, EStructuralFeature eStructuralFeature) {
			super(eStructuralFeature.getName());
			this.idEObject = idEObject;
			this.eStructuralFeature = eStructuralFeature;
		}

		@Override
		public int getChildCount() {
			if (nodes == null) {
				init();
			}
			return nodes.size();
		}

		private void init() {
			nodes = new ArrayList<TreeNode>();
			if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.isMany()) {
					List list = (List) idEObject.eGet(eStructuralFeature);
					for (Object o : list) {
						nodes.add(new ObjectNode((IdEObject) o));
					}
				} else {
					if (idEObject.eGet(eStructuralFeature) != null) {
						nodes.add(new ObjectNode((IdEObject) idEObject.eGet(eStructuralFeature)));
					}
				}
			} else if (eStructuralFeature instanceof EAttribute) {
				if (eStructuralFeature.isMany()) {
					List list = (List) idEObject.eGet(eStructuralFeature);
					for (Object o : list) {
						nodes.add(new LeafNode(o));
					}
				} else {
					if (idEObject.eGet(eStructuralFeature) != null) {
						nodes.add(new LeafNode(idEObject.eGet(eStructuralFeature)));
					}
				}
			}
		}

		@Override
		public TreeNode getChildAt(int index) {
			if (nodes == null) {
				init();
			}
			return nodes.get(index);
		}
	}

	public static class ObjectNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = 3005180498837681862L;
		private final IdEObject idEObject;
		private Map<EStructuralFeature, TreeNode> children;

		public ObjectNode(IdEObject idEObject) {
			super(idEObject.eClass().getName() + " (" + idEObject.getOid() + ")");
			this.idEObject = idEObject;
		}

		@Override
		public int getChildCount() {
			if (children == null) {
				init();
			}
			return children.size();
		}

		private void init() {
			children = new HashMap<EStructuralFeature, TreeNode>();
			for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
				if (!children.containsKey(eStructuralFeature)) {
					children.put(eStructuralFeature, new StructuralFeatureNode(idEObject, eStructuralFeature));
				}
			}
		}

		@Override
		public TreeNode getChildAt(int index) {
			if (children == null) {
				init();
			}
			return children.get(idEObject.eClass().getEAllStructuralFeatures().get(index));
		}
	}

	private void start(IfcModel model, String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtil.setLookAndFeelToNice();
		setSize(800, 600);
		setTitle("Visualiser - " + name);
		getContentPane().setLayout(new BorderLayout());

		ObjectNode root = new ObjectNode(model.get(IfcProject.class));
		Model newModel = new Model(root);
		JTree tree = new JTree(newModel);
		JScrollPane scrollPane = new JScrollPane(tree);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
	}
}