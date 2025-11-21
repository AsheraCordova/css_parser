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
package com.ashera.css;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ashera.parser.css.CssResult;
import com.ashera.parser.css.FontFace;

public class CssTree {
	public class Attribute {
		public String key;
		public String value;
		public String orientation = "default";
		public String minWidth;
		public String minHeight;
		public String maxWidth;
		public String maxHeight;
		
		public Attribute(String key, String value) {
			this.key = key;
			this.value = value;
		}

	}
	private HashMap<String, List<Attribute>> attributes = new HashMap<>();
	private List<FontFace> fontFaces = new ArrayList<>();
	private FontFace fontFace = new FontFace();
	
	public void end() {
		if (!fontFace.getFontConfig().isEmpty()) {
			fontFace = new FontFace();
		}
	}
	
	public void setAttribute(String gaurdKeys, String gaurdValues, String attributeName, String key, String value) {
		// remove double quotes
		value = value.replace("\"", "");
		
		if (attributeName.equals("@font-face")) {
			fontFace.getFontConfig().put(key, value);
			if (!fontFaces.contains(fontFace)) {
				fontFaces.add(fontFace);
			}
			return;
		}
		
		List<Attribute> attributeLst = attributes.get(attributeName);
		if (attributeLst == null) {
			attributeLst = new ArrayList<>();
			attributes.put(attributeName, attributeLst);			
		}
		
		Attribute e = new Attribute(key, value);
		attributeLst.add(e);
		if (!gaurdKeys.equals("default")) {
			String[] keys = gaurdKeys.split(",");
			String[] values = gaurdValues.split(",");

			for (int i = 0; i < keys.length; i++) {
				String gaurdKey = keys[i];
				
				switch (gaurdKey) {
				case "orientation":
					e.orientation = values[i];
					break;
				case "min-width":
					e.minWidth = values[i];
						break;
				case "max-width":
					e.maxWidth = values[i];
						break;
				case "min-height":
					e.minHeight = values[i];
						break;
				case "max-height":
					e.maxHeight = values[i];
						break;
				default:
					break;
				}
				
			}
		}
	}
	
	public List<Attribute> getStyle(String selector) {
		return attributes.get(selector);
	}
	
	public void getCss(String tag, String classNames, String id, CssResult cssResult) {
		updateAttributes(tag, cssResult);
			
		if (classNames != null) {
			String[] selectorArr = classNames.split("\\s");		

			for (String selector : selectorArr) {
				updateAttributes("." +selector, cssResult);
				
			}
		}	
		
		updateAttributes("#" +id, cssResult);	
	}
	
	public List<FontFace> getFontFaces() {
		return fontFaces;
	}
	
	

	private void updateAttributes(String selector,
			CssResult cssResult) {
		List<Attribute> attributeLst = attributes.get(selector);
		
		if (attributeLst != null) {
			for (Attribute attribute : attributeLst) {
				cssResult.put(attribute.key, attribute);
			}
		}
	}
}
