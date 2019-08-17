package com.xuxi.networktest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //开始解析的时候调用
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析某个点的时候调用

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        //在获取节点内容的时候调用
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //在完成解析某个节点的时候调用
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        //在完成整个XML解析的时候调用
        
    }
}
