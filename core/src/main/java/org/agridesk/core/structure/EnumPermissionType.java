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
 * Enumération des types de droits possibles.
 * 
 * @author <a href="mailto:nicolas.audeon@smartagri.eu">Nicolas Audeon</a>
 */
public enum EnumPermissionType {

	CREATE("create"),
	
	UPDATE("update"),
	
	DELETE("delete"),
	
	LIST("list"),
	
	COUNT("count"),
	
	EXECUTE("execute"),
	
	READ("read"),
	
	WRITE("write");
		
	private final String code;
	
	private EnumPermissionType(final String pCode) {
		this.code = pCode;		
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static EnumPermissionType fromCode(final String pCode) {
		if ("create".equals(pCode)) {
			return EnumPermissionType.CREATE;
		} else if ("update".equals(pCode)) {
			return EnumPermissionType.UPDATE;
		} else if ("delete".equals(pCode)) {
			return EnumPermissionType.DELETE;
		} else if ("list".equals(pCode)) {
			return EnumPermissionType.LIST;
		} else if ("count".equals(pCode)) {
			return EnumPermissionType.COUNT;
		} else if ("execute".equals(pCode)) {
			return EnumPermissionType.EXECUTE;
		} else if ("read".equals(pCode)) {
			return EnumPermissionType.READ;
		} else if ("write".equals(pCode)) {
			return EnumPermissionType.WRITE;
		} else if ("update".equals(pCode)) {
			return EnumPermissionType.UPDATE;
		} else if ("update".equals(pCode)) {
			return EnumPermissionType.UPDATE;
		} else if ("update".equals(pCode)) {
			return EnumPermissionType.UPDATE;
		} else {
			throw new IllegalArgumentException("Invalide pCode");
		}
	}
	
}
