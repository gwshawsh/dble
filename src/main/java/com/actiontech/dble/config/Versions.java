/*
* Copyright (C) 2016-2017 ActionTech.
* based on code by MyCATCopyrightHolder Copyright (c) 2013, OpenCloudDB/MyCAT.
* License: http://www.gnu.org/licenses/gpl.html GPL version 2 or higher.
*/
package com.actiontech.dble.config;

/**
 * @author
 */
public abstract class Versions {

    public static final byte PROTOCOL_VERSION = 10;

    private static byte[] serverVersion = "5.6.29-dble-2.17.09.0-dev-20171017155106".getBytes();
    public static final byte[] VERSION_COMMENT = "dble Server (ActionTech)".getBytes();
    public static final String ANNOTATION_NAME = "dble:";
    public static final String ROOT_PREFIX = "dble";
    public static final String DOMAIN = "http://dble.cloud/";

    public static void setServerVersion(String version) {
        byte[] mysqlVersionPart = version.getBytes();
        int startIndex;
        for (startIndex = 0; startIndex < serverVersion.length; startIndex++) {
            if (serverVersion[startIndex] == '-')
                break;
        }

        // concat version
        byte[] newVersion = new byte[mysqlVersionPart.length + serverVersion.length - startIndex];
        System.arraycopy(mysqlVersionPart, 0, newVersion, 0, mysqlVersionPart.length);
        System.arraycopy(serverVersion, startIndex, newVersion, mysqlVersionPart.length,
                serverVersion.length - startIndex);
        serverVersion = newVersion;
    }

    public static byte[] getServerVersion() {
        return serverVersion;
    }
}
