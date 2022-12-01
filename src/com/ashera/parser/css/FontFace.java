package com.ashera.parser.css;

import java.util.HashMap;
import java.util.Map;

public class FontFace {
	private Map<String, String> fontConfig = new HashMap<>();

	public Map<String, String> getFontConfig() {
		return fontConfig;
	}

	public void setFontConfig(Map<String, String> fontConfig) {
		this.fontConfig = fontConfig;
	}
	
}
