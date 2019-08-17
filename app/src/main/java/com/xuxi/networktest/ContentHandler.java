package com.xuxi.networktest;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentHandler extends DefaultHandler {

    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //开始解析的时候调用
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开机解析某个点的时候调用
        nodeName = localName;//记录当前节点名
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //在获取节点内容的时候调用
        //根据当前的节点名判断将内容添加到哪一个StringBuiler对象中
        if ("id".equals(nodeName)){
            id.append(ch,start,length);
        }else if("name".equals(nodeName)){
            name.append(ch,start,length);
        }else if("version".equals(nodeName)){
            version.append(ch,start,length);
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //在完成某个节点的时候调用

        if ("app".equals(localName)){
            Log.d("ContentHandler", "id is " + id.toString().trim());
            Log.d("ContentHandler", "name is " + name.toString().trim());
            Log.d("ContentHandler", "version is " + version.toString().trim());
            //最后要将StringBuiler清空掉
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        //在完成这个xml解析的时候调用
    }


}
