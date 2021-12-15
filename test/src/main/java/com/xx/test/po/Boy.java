package com.xx.test.po;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sourcesystemid",
        "targetsystemid",
        "instanceid",
        "cacode",
        "schemaversion",
        "typeflag",
        "datasetcode",
        "xmlcontent",
        "userid",
        "username",
        "requesttime"
})
public class Boy {
    @XmlElement(name = "SOURCE_SYSYTEM_ID", required = true)
    protected String sourcesystemid;
    @XmlElement(name = "TARGET_SYSTEM_ID", required = true)
    protected String targetsystemid;
    @XmlElement(name = "INSTANCE_ID", required = true)
    protected String instanceid;
    @XmlElement(name = "CA_CODE", required = true)
    protected String cacode;
    @XmlElement(name = "SCHEMA_VERSION", required = true)
    protected String schemaversion;
    @XmlElement(name = "TYPE_FLAG")
    protected int typeflag;
    @XmlElement(name = "DATASET_CODE", required = true)
    protected String datasetcode;
    @XmlElement(name = "XML_CONTENT", required = true)
    protected byte[] xmlcontent;
    @XmlElement(name = "USER_ID", required = true)
    protected String userid;
    @XmlElement(name = "USER_NAME", required = true)
    protected String username;
    @XmlElement(name = "REQUEST_TIME", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requesttime;

    public String getSourcesystemid() {
        return sourcesystemid;
    }

    public void setSourcesystemid(String sourcesystemid) {
        this.sourcesystemid = sourcesystemid;
    }

    public String getTargetsystemid() {
        return targetsystemid;
    }

    public void setTargetsystemid(String targetsystemid) {
        this.targetsystemid = targetsystemid;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }

    public String getCacode() {
        return cacode;
    }

    public void setCacode(String cacode) {
        this.cacode = cacode;
    }

    public String getSchemaversion() {
        return schemaversion;
    }

    public void setSchemaversion(String schemaversion) {
        this.schemaversion = schemaversion;
    }

    public int getTypeflag() {
        return typeflag;
    }

    public void setTypeflag(int typeflag) {
        this.typeflag = typeflag;
    }

    public String getDatasetcode() {
        return datasetcode;
    }

    public void setDatasetcode(String datasetcode) {
        this.datasetcode = datasetcode;
    }

    public byte[] getXmlcontent() {
        return xmlcontent;
    }

    public void setXmlcontent(byte[] xmlcontent) {
        this.xmlcontent = xmlcontent;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public XMLGregorianCalendar getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(XMLGregorianCalendar requesttime) {
        this.requesttime = requesttime;
    }
}
