/***

DISCLAIMER: The sample code described herein is provided on an "as is" basis, without
warranty of any kind, to the fullest extent permitted by law. ForgeRock does not warrant
or guarantee the individual success developers may have in implementing the sample code on
their development platforms or in production configurations.
ForgeRock does not warrant, guarantee or make any representations regarding the
use, results of use, accuracy, timeliness or completeness of any data or information relating to the sample code.
ForgeRock disclaims all warranties, expressed or implied, and in particular, disclaims all warranties of merchantability,
and warranties related to the code, or any service or software related thereto.
ForgeRock shall not be liable for any direct, indirect or consequential damages or costs of any type arising
out of any action taken by you or others related to the sample code.

 ***
 */
package org.forgerock.openam.authentication.plugins;

import com.iplanet.sso.SSOToken;
import com.sun.identity.authentication.spi.AMPostAuthProcessInterface;
import com.sun.identity.authentication.spi.AuthenticationException;
import com.sun.identity.shared.debug.Debug;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PopulateSessionPlugin implements AMPostAuthProcessInterface {
    public PopulateSessionPlugin() {
    }

    public void onLoginSuccess(Map requestParamsMap, HttpServletRequest request, HttpServletResponse response, SSOToken token) throws AuthenticationException {
        new HashMap();
        Debug debug = Debug.getInstance("PopulateSessionPlugin");

        try {
            token.setProperty("tokenID", token.getTokenID().toString());
            debug.message(token.getTokenID().toString());
        } catch (Exception e) {
            debug.error("PopulateSession.onLoginSuccess : Unable to update session values : ", e);
        }

    }

    public void onLoginFailure(Map requestParamsMap, HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    }

    public void onLogout(HttpServletRequest request, HttpServletResponse response, SSOToken token) throws AuthenticationException {
    }
}

