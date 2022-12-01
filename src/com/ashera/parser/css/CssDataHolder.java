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
