/*******************************************************************************
 * Copyright (C) 2022 the Eclipse BaSyx Authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package org.eclipse.basyx.examples.scenarios.authorization;

import org.eclipse.basyx.components.IComponent;
import org.eclipse.basyx.vab.protocol.http.server.BaSyxHTTPServer;

/**
 * Utility class for runtime shutdown logic.
 *
 * @author wege
 */
public final class ShutdownHookUtil {
	private ShutdownHookUtil() {
	}

	public static void addShutdownHook(IComponent component) {
		Thread shutdownListener = new Thread(component::stopComponent);
		Runtime.getRuntime().addShutdownHook(shutdownListener);
	}

	public static void addShutdownHook(BaSyxHTTPServer server) {
		Thread shutdownListener = new Thread(server::shutdown);
		Runtime.getRuntime().addShutdownHook(shutdownListener);
	}

	public static void addShutdownHook(Runnable runnable) {
		Thread shutdownListener = new Thread(runnable);
		Runtime.getRuntime().addShutdownHook(shutdownListener);
	}
}
