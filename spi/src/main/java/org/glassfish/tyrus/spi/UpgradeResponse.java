/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.tyrus.spi;

import javax.websocket.HandshakeResponse;
import java.util.List;

/**
 * Handshake response.
 *
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
public abstract class UpgradeResponse implements HandshakeResponse {

    /**
     * Get HTTP status.
     *
     * @return HTTP status.
     */
    public abstract int getStatus();

    /**
     * Set HTTP status.
     *
     * @return HTTP status.
     */
    public abstract void setStatus(int status);

    /**
     * Get HTTP reason phrase.
     *
     * @return reason phrase.
     */
    public abstract void setReasonPhrase(String reason);

    /**
     * Sets a response header with the given name and value.
     * If the header had already been set, the new value overwrites the
     * previous one.
     *
     * @param name the name of the header
     * @param value	the header value  If it contains octet string,
     *		it should be encoded according to RFC 2047
     *		(http://www.ietf.org/rfc/rfc2047.txt)
     */
    public abstract void setHeader(String name, String value);

    /**
     * Gets the first header value from the {@link List} of header values corresponding to the name.
     *
     * @param name header name.
     * @return {@link String} value iff it exists, {@code null} otherwise.
     */
    public String getFirstHeaderValue(String name) {
        final List<String> stringList = getHeaders().get(name);
        return stringList == null ? null : (stringList.size() > 0 ? stringList.get(0) : null);
    }
}
