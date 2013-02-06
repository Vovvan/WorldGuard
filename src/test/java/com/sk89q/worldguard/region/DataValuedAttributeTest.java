// $Id$
/*
 * This file is a part of WorldGuard.
 * Copyright (c) sk89q <http://www.sk89q.com>
 * Copyright (c) the WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY), without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
*/

package com.sk89q.worldguard.region;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Test;

public class DataValuedAttributeTest extends AttributeTest {
    
    private DataValuedAttribute makeAttribute(String name) {
        return new DataValuedAttribute(name);
    }

    @Test
    public void testRead() throws IOException {
        DataValuedAttribute attribute = makeAttribute("testing");
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6 };
        attribute.read(new DataInputStream(new ByteArrayInputStream(data)), data.length);
        assertArrayEquals(data, attribute.getByteArray());
    }

    @Test
    public void testWrite() throws IOException {
        byte[] data = new byte[] { 1, 2, 3, 4, 5, 6 };
        DataValuedAttribute attribute = makeAttribute("testing");
        attribute.setByteArray(data);
        
        ByteArrayOutputStream stream = new ByteArrayOutputStream(100);
        attribute.write(new DataOutputStream(stream));
        assertArrayEquals(data, stream.toByteArray());
    }

}
