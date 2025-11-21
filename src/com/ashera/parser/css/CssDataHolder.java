//start - license
/*
 * Copyright (c) 2025 Ashera Cordova
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
//end - license
package com.ashera.parser.css;

import java.util.List;

import com.ashera.css.CssTree;
import com.ashera.css.CssTree.Attribute;
import com.ashera.css.Evaluator;
import com.ashera.css.ParseException;
import com.ashera.css.StyleSheet;


public class CssDataHolder implements StyleSheet{
	private CssTree cssTree = new CssTree();
	
	public void addCss(String cssContentStr) {
		try {
			new Evaluator(new java.io.StringReader(cssContentStr)).S(cssTree);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	public void getCss(String tag, String classNames, String id, CssResult cssResult) {
		cssTree.getCss(tag, classNames, id, cssResult);
	}
	
	public List<FontFace> getFonts() {
		return cssTree.getFontFaces();
	}
	
	public List<Attribute> getStyle(String selector) {
		return cssTree.getStyle(selector);
	}
}
