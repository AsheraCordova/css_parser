package com.ashera.parser.css;

import com.ashera.css.CssTree.Attribute;

public interface CssResult {
	void put(String key, Attribute value);
}
