/*
    Copyright (C) 2007-2012  Olivier ROLAND (olivier.roland@edla.org)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses/.
 */

package org.edla.dico.construct;

import java.io.InputStream;
import java.util.Properties;

public class DicoProperties {

	public String root;

	public String xmlFile;

	public String wordsFile;

	public String exclusFile;
	
	public String language;
	
	public String languageShort;

	public static DicoProperties getInstance() {
		if (null == DicoProperties.instance) {
			DicoProperties.instance = new DicoProperties();
		}
		return DicoProperties.instance;
	}

	private static DicoProperties instance;

	private DicoProperties() {
		/*
		 * final Properties prop = new Properties(); try { final FileInputStream
		 * in = new FileInputStream("/home/hack/dico.properties");
		 * prop.load(in); in.close(); } catch (final Exception e) {
		 * e.printStackTrace(); }
		 */
		Properties prop = new Properties();
		System.out.println(this.getClass().getPackage().getName()); 
		InputStream stream = this.getClass().getResourceAsStream(
				"dico.properties");
		try {
			prop.load(stream);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		this.root = prop.getProperty("root");
		this.wordsFile = prop.getProperty("wordsFile");
		this.exclusFile = prop.getProperty("exclusFile");
		this.xmlFile = prop.getProperty("xmlFile");
		this.language = prop.getProperty("language");
		this.languageShort = prop.getProperty("languageShort");
	}
}
