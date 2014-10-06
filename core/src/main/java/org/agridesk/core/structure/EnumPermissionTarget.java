//============================================================================= 
// Copyright (c) 2014 SmartAgri.eu. Tous droits reservés.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//=============================================================================
package org.agridesk.core.structure;

/**
 * Enumération des cibles possibles des droits.
 * 
 * @author <a href="mailto:nicolas.audeon@smartagri.eu">Nicolas Audeon</a>
 */
public enum EnumPermissionTarget {
	
	/**
	 * Le droit porte sur une fonction.
	 */
	FONCTION("fonction"),
	
	/**
	 * Le droit porte sur une donnée.
	 */
	DATA("data");
	 
	private final String code;
	
	private EnumPermissionTarget(final String pCode) {
		this.code = pCode;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static EnumPermissionTarget fromCode(final String pCode) {
		if ("data".equals(pCode)) {
			return EnumPermissionTarget.DATA;
		} else if ("fonction".equals(pCode)) {
			return EnumPermissionTarget.FONCTION;
		} else {
			throw new IllegalArgumentException("Invalide pCode");
		}
	}
	
}
