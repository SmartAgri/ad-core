//============================================================================= 
// Copyright (c) 2014 SmartAgri.eu. Tous droits reserv�s.
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
package org.agridesk.security;

import org.agridesk.core.structure.EnumPermissionType;
import org.vertx.java.core.AsyncResultHandler;
import org.vertx.java.core.json.JsonObject;

/**
 * Interface de d�finition du gestionnaire de s�curit�.
 * 
 * @author <a href="mailto:nicolas.audeon@smartagri.eu">Nicolas Audeon</a>
 */
public interface ISecurityManager {
	
	/**
	 * Tente de connecter un utilisateur.
	 * <p>
	 * Le r�sultat de cette op�ration est un <code>JsonObject</code> qui : 
	 * <ul>
	 * <li> si l'op�ration �choue contient :
	 * <pre>
	 * {
	 * 	"error" : true,
	 *  "message" : "<le message de l'erreur localis�>"
	 *  "trace" : "<la trace compl�te de l'erreur si elle existe>" 
	 * }
	 * </pre>
	 * </li>
	 * <li> si l'op�ration r�ussie contient :
	 * <pre>
	 * {
	 * 	"error" : false,
	 *  "sessionId" : "<L'identifiant unique de la session>"
	 *  "userEmail" : "<L'email de l'utilisateur tel que fourni en param�tre>"
	 *  "userName" : "<Le nom complet de l'utilisateur. Celui-ci est le r�sultat de la concat�nation du titre (localis�), du nom et du pr�nom de l'utilisateur>"
	 *  "organizationId" : "<L'identifiant unique de l'organisation de l'utilisateur>" 
	 * }
	 * </pre>
	 * </li>
	 * </ul>
	 * </p>
	 * @param pUserEmail l'email de l'utilisateur.
	 * @param pPassword le mot de passe.
	 * @param pLang le code langue de l'utilisateur.
	 * @param pResult le r�sultat de l'op�ration.
	 */
	void login(final String pUserEmail, final String pPassword, final String pLang, final AsyncResultHandler<JsonObject> pResult);
	
	/**
	 * Tente de d�connecter un utilisateur.
	 * <p>
	 * Le r�sultat de cette op�ration est un <code>JsonObject</code> qui : 
	 * <ul>
	 * <li> si l'op�ration �choue contient :
	 * <pre>
	 * {
	 * 	"error" : true,
	 *  "message" : "<le message de l'erreur localis�>" 
	 *  "trace" : "<la trace compl�te de l'erreur si elle existe>"
	 * }
	 * </pre>
	 * </li>
	 * <li> si l'op�ration r�ussie contient :
	 * <pre>
	 * {
	 * 	"error" : false,
	 * }
	 * </pre>
	 * </li>
	 * </ul>
	 * </p>
	 * @param pSessionId l'identifiant unique de la session de l'utilisateur.
	 * @param pLang le code langue de l'utilisateur.
	 * @param pResult le r�sultat de l'op�ration.
	 */
	void logout(final String pSessionId, final String pLang, final AsyncResultHandler<JsonObject> pResult);

	/**
	 * V�rifie si l'acc�s � une fonction est ou non possible.
	 * Le r�sultat de cette op�ration est un <code>JsonObject</code> qui : 
	 * <ul>
	 * <li> si l'op�ration �choue contient :
	 * <pre>
	 * {
	 * 	"error" : true,
	 *  "message" : "<le message de l'erreur localis�>" 
	 *  "trace" : "<la trace compl�te de l'erreur si elle existe>"
	 * }
	 * </pre>
	 * </li>
	 * <li> si l'op�ration r�ussie contient :
	 * <pre>
	 * {
	 * 	"error" : false,
	 *  "authorized" : <true ou false>
	 * }
	 * </pre>
	 * </li>
	 * </ul>
	 * </p>
	 * @param pSessionId l'identifiant unique de la session de l'utilisateur demandeur.
	 * @param pOrganizationId l'identifiant unique de l'organisation d'appartenance de l'utilisateur demandeur.
	 * @param pPlugIn le code du module.
	 * @param pFonction le code de la fonction.
	 * @param pActionType le type de permission � v�rifier.
	 * @param pResult le r�sultat de l'op�ration.
	 */
	void isAuthorized(final String pSessionId, final String pOrganizationId, final String pPlugIn, final String pFonction, final EnumPermissionType pActionType, final AsyncResultHandler<JsonObject> pResult);
		
}
