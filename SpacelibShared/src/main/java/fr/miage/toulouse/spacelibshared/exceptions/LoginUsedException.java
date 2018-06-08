/*
 * Copyright (C) 2018 Rémi Venant $lt;remi.venant@gmail.com$gt;.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package fr.miage.toulouse.spacelibshared.exceptions;

/**
 *
 * @author Fanny MONTUY;
 */
public class LoginUsedException extends Exception {

    /**
     * Creates a new instance of <code>UtilisateurInconnuException</code> without detail message.
     */
    public LoginUsedException() {
    }

    /**
     * Constructs an instance of <code>UtilisateurInconnuException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public LoginUsedException(String msg) {
        super(msg);
    }
}
