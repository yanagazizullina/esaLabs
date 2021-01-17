<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Plants</title>
            </head>
            <body>
                <table>
                    <tr>
                        <td><strong>Id</strong></td>
                        <td><strong>Name</strong></td>
                        <td><strong>Genus</strong></td>
                        <td><strong>Lighting</strong></td>
                        <td><strong>Watering</strong></td>
                        <td><strong>Temperature</strong></td>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="genus"/></td>
                            <td><xsl:value-of select="lighting"/></td>
                            <td><xsl:value-of select="watering"/></td>
                            <td><xsl:value-of select="temperature"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>