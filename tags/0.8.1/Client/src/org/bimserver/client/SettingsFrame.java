package org.bimserver.client;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import org.bimserver.utils.SpringUtilities;

public class SettingsFrame extends JDialog {

	private static final long serialVersionUID = 7538889281189795220L;

	public SettingsFrame(final Client testClient) {
		setIconImage(testClient.getIconImage());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setModal(true);
		setTitle("Connect");
		getContentPane().setLayout(new SpringLayout());
		JLabel usernameLabel = new JLabel("Username");
		getContentPane().add(usernameLabel);
		final JTextField usernameField = new JTextField(20);
		usernameField.setText(testClient.getServiceHolder().getUsername());
		getContentPane().add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password");
		getContentPane().add(passwordLabel);
		final JTextField passwordField = new JTextField(20);
		passwordField.setText(testClient.getServiceHolder().getPassword());
		getContentPane().add(passwordField);
		
		JLabel serverLabel = new JLabel("Server URL");
		getContentPane().add(serverLabel);
		final JTextField serverField = new JTextField(25);
		serverField.setText(testClient.getServiceHolder().getAddress());
		getContentPane().add(serverField);
			
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		getContentPane().add(cancel);
		
		JButton save = new JButton("Connect");
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.WAIT_CURSOR));
				if (testClient.getServiceHolder().connect(serverField.getText(), usernameField.getText(), passwordField.getText())) {
					setVisible(false);
					testClient.setTitle(Client.APP_NAME + " - Connected to " + usernameField.getText() + "@" + serverField.getText());
					testClient.updateTree();
					testClient.expandTree();
				}
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}});
		getContentPane().add(save);
		
		SpringUtilities.makeCompactGrid(getContentPane(),
                4, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad
		pack();
		setLocationRelativeTo(testClient);
	}
}
