package org.bimserver.test.framework;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.nio.charset.Charset;
import java.util.SortedMap;

public class DumpCharsets {
	public static void main(String[] args) {
		SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
		for (String s : availableCharsets.keySet()) {
			System.out.println(s + ": " + availableCharsets.get(s));
		}
	}
}
