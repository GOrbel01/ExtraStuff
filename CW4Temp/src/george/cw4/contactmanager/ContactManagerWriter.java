package george.cw4.contactmanager;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import george.cw4.contact.Contact;
import george.cw4.meeting.DateUtil;
import george.cw4.meeting.Meeting;
import george.cw4.meeting.PastMeeting;
import org.w3c.dom.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Cloud on 19/12/2014.
 */
public final class ContactManagerWriter {


}
