package com.adwait.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.adwait.model.Country;

@Service
public class CountryService {

	public List<Country> showAllCountries() {

		List<Country> countries = new ArrayList<>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("./src/documents/countries.xml");

			NodeList countryList = doc.getElementsByTagName("country");

			for (int i = 0; i < countryList.getLength(); i++) {
				Node country = countryList.item(i);
				Country c = new Country();
				if (country.getNodeType() == Node.ELEMENT_NODE) {
					Element countryElement = (Element) country;

					NodeList nameList = countryElement.getElementsByTagName("name");

					for (int j = 0; j < nameList.getLength(); j++) {
						Node n = nameList.item(j);

						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;

							c.setCountry(name.getTextContent());

						}
					}
					NodeList statusList = countryElement.getElementsByTagName("unMemberStatus");

					for (int k = 0; k < statusList.getLength(); k++) {
						Node s = statusList.item(k);

						if (s.getNodeType() == Node.ELEMENT_NODE) {
							Element status = (Element) s;

							c.setUnMemberStatus(status.getTextContent());
						}
					}
					NodeList sovDisputeList = countryElement.getElementsByTagName("sovereigntyDispute");

					for (int l = 0; l < sovDisputeList.getLength(); l++) {
						Node sov = sovDisputeList.item(l);

						if (sov.getNodeType() == Node.ELEMENT_NODE) {
							Element sovDis = (Element) sov;

							c.setSovereigntyDispute(sovDis.getTextContent());
						}
					}
					NodeList moreInfoList = countryElement.getElementsByTagName("moreInfo");

					for (int m = 0; m < moreInfoList.getLength(); m++) {
						Node moreInfo = moreInfoList.item(m);

						if (moreInfo.getNodeType() == Node.ELEMENT_NODE) {
							Element mI = (Element) moreInfo;

							c.setMoreInfo(mI.getTextContent());
						}
					}

				}
				countries.add(c);
			}
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		return countries;
	}
}
