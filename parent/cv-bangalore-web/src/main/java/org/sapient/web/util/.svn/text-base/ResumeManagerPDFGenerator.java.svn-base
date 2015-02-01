package org.sapient.web.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.jfree.util.Log;
import org.sapient.service.client.ContactInfoVO;
import org.sapient.service.client.EducationInfoVO;
import org.sapient.service.client.EmploymentInfoVO;
import org.sapient.service.client.PersonalInfoVO;
import org.sapient.service.client.ProfileSummaryInfoVO;
import org.sapient.service.client.ProjectInfoVO;
import org.sapient.service.client.RecognitionInfoVO;
import org.sapient.service.client.SkillsInfoVO;
import org.sapient.service.client.UserInfoVO;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author spash1
 * 
 */
@Component("resumeManagerPDFGenerator")
public class ResumeManagerPDFGenerator {

	/** Path to the resulting PDF file. */
	public static final String RESULT = "/home/rms/Desktop/Resume.pdf";

	/** Path to an image. */
	public static final String RESOURCE = "http://localhost:8080/CVBangaloreWeb/images/Sapient_Resume_Logo.JPG";
	/** The path to the font. */
	public static final String FONTCalibri = "c:/windows/fonts/CALIBRI.TTF";

	Image img;

	public ByteArrayOutputStream generatePDF(UserInfoVO userdetails)
			throws DocumentException, IOException {

		ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
		// step 1
		// landscape format using the rotate() method
		Document document = new Document(PageSize.A4);

		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, baosPDF);
		

		// Define the font to be used
		Font font = FontFactory.getFont(FONTCalibri, 10);
		Font fontbold = FontFactory.getFont(FONTCalibri, 10, Font.BOLD,
				BaseColor.RED);
		Font fontHeaderName = FontFactory.getFont(FONTCalibri, 10, Font.BOLD,
				BaseColor.BLACK);
		Font fontboldNormal = FontFactory
				.getFont(FONTCalibri, 10, Font.BOLD);
		
		Font fontItalics = FontFactory
		.getFont(FONTCalibri, 10, Font.BOLDITALIC);

		// step 3
		document.open();

		// Adding a series of images
		Image img = Image.getInstance(String.format("%s", RESOURCE));
		if (img.getScaledWidth() > 150 || img.getScaledHeight() > 150) {
			img.scaleToFit(150, 150);
		}
		document.add(new Paragraph(String.format("", RESOURCE, img.getClass()
				.getName())));
		document.add(img);
		document.add(Chunk.NEWLINE);

		List<ContactInfoVO> contacts = userdetails.getContactDetails();

		PersonalInfoVO personalDetails = userdetails.getPersonalDetails();

		List<ProfileSummaryInfoVO> profileSummaryDetails = userdetails
				.getProfileSummaryDetails();

		List<EmploymentInfoVO> employementDetails = userdetails
				.getEmploymentDetails();

		List<ProjectInfoVO> projectDetails = userdetails.getProjectDetails();

		List<EducationInfoVO> educationDetails = userdetails
				.getEducationDetails();

		List<SkillsInfoVO> skills = userdetails.getSkillSets();

		List<RecognitionInfoVO> recognitions = userdetails
				.getRecognitionDetails();

		BaseColor bColor = BaseColor.ORANGE;

		// step 4
		Chunk chunk = new Chunk(personalDetails.getFirstName() + " "+personalDetails.getMiddleName()+" "
				+ personalDetails.getLastName() + " , "
				+ personalDetails.getDesignation(),fontHeaderName);

		chunk.setUnderline(bColor, +1f, 0f, -2f, 0f, 1);
		chunk.setHorizontalScaling(2f);

		Paragraph pPersonal = new Paragraph();
		pPersonal.add(chunk);
		pPersonal.setIndentationLeft(150f);

		document.add(pPersonal);
		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		for (ProfileSummaryInfoVO profileSummary : profileSummaryDetails) {

			Log.info("generate Pdf" + profileSummary.getTitle());

			
			  Paragraph pProfile = new Paragraph(profileSummary.getTitle(),
			  fontboldNormal); pProfile.setIndentationLeft(150f);
			  
			  document.add(pProfile);
			 
			  document.add(Chunk.NEWLINE);
			
		}

		Paragraph paraProfile = new Paragraph("Profile Summary", fontbold);

		paraProfile.setIndentationLeft(150f);
		document.add(paraProfile);

		document.add(Chunk.NEWLINE);
		for (ProfileSummaryInfoVO profileSummary : profileSummaryDetails) {

			Log.info("generate Pdf" + profileSummary.getTitle());

			/*
			 * Paragraph pProfile = new Paragraph(profileSummary.getTitle(),
			 * font); pProfile.setIndentationLeft(150f);
			 * 
			 * document.add(pProfile);
			 */

			Paragraph pDesc = new Paragraph(profileSummary.getDescription(),
					font);
			pDesc.setIndentationLeft(150f);

			document.add(pDesc);
		}
		document.add(Chunk.NEWLINE);
		Paragraph paraWork = new Paragraph("Work Experience", fontbold);
		paraWork.setIndentationLeft(150f);
		document.add(paraWork);
		document.add(Chunk.NEWLINE);

		for (EmploymentInfoVO employement : employementDetails) {
			Paragraph pEmp = null;
			if (employement.getDateOfRelieving() != null) {
				pEmp = new Paragraph(employement.getEmployerName()
						+ " "
						+ DateFormatUtil.formatEmploymentDate(employement
								.getDateOfJoining().toGregorianCalendar()
								.getTime())
						+ " to "
						+ DateFormatUtil.formatEmploymentDate(employement
								.getDateOfRelieving().toGregorianCalendar()
								.getTime()), font);
			} else {
				pEmp = new Paragraph(employement.getEmployerName()
						+ " "
						+ DateFormatUtil.formatEmploymentDate(employement
								.getDateOfJoining().toGregorianCalendar()
								.getTime()) + " to Till Date",font);
			}

			pEmp.setIndentationLeft(150f);
			document.add(pEmp);
		}
		
		document.add(Chunk.NEWLINE);
		Paragraph paraProject = new Paragraph("Project Summary", fontbold);
		paraProject.setIndentationLeft(150f);
		document.add(paraProject);
		
		
		for (ProjectInfoVO project : projectDetails) {

			document.add(Chunk.NEWLINE);

			Paragraph pProjectRole = new Paragraph(project.getRole() + "-"
					+ project.getTitle(), fontboldNormal);
			pProjectRole.setIndentationLeft(150f);
			document.add(pProjectRole);

			Paragraph pProjectDesc = new Paragraph(
					project.getDescription(), font);
			pProjectDesc.setIndentationLeft(150f);
			document.add(pProjectDesc);
			
			document.add(Chunk.NEWLINE);
			
			Paragraph pProjectBusinessValues = new Paragraph(
					"Business Values", fontItalics);
			pProjectBusinessValues.setIndentationLeft(150f);
			document.add(pProjectBusinessValues);
			
			Paragraph pProjectResponsibilities = new Paragraph(
					project.getResponsibilities(), font);
			pProjectResponsibilities.setIndentationLeft(150f);
			document.add(pProjectResponsibilities);

		}

		document.add(Chunk.NEWLINE);
		Paragraph paraEdu = new Paragraph("Education Details", fontbold);
		paraEdu.setIndentationLeft(150f);
		document.add(paraEdu);
		for (EducationInfoVO education : educationDetails) {

			
			String commaSeparatedSpec = education.getSpecialization()+",";
			
			education
					.setSpecialization(education.getSpecialization().equals("") ? " "
							: commaSeparatedSpec );

			Paragraph pEduUniversity = new Paragraph(education.getUniversity(),
					fontboldNormal);
			pEduUniversity.setIndentationLeft(150f);
			document.add(pEduUniversity);

			Paragraph pEduCourse = new Paragraph(
					education.getCourseName()
							+ ","
							+ education.getSpecialization()
							+ DateFormatUtil.formatEmploymentDate(education
									.getYearOfPassing().toGregorianCalendar()
									.getTime()), font);
			pEduCourse.setIndentationLeft(150f);
			document.add(pEduCourse);

			document.add(Chunk.NEWLINE);
		}

		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);

		Paragraph pSkill = new Paragraph("Skill Sets :", fontbold);
		pSkill.setIndentationLeft(150f);
		document.add(pSkill);

		for (SkillsInfoVO skill : skills) {

			PdfPTable table = new PdfPTable(2);
			//table.addCell(skill.getSkillsType().getDescription());
			PdfPCell cellOne =  new PdfPCell(   new Phrase(skill.getSkillsType().getDescription(), font));
			cellOne.setBorder(Rectangle.NO_BORDER); 
			table.addCell(cellOne);

			//table.addCell(skill.getItems());
			PdfPCell cellTwo =  new PdfPCell( new Phrase(skill.getItems(),font));
			cellTwo.setBorder(Rectangle.NO_BORDER); 
			table.addCell(cellTwo);

			Paragraph pSkillData = new Paragraph();
			pSkillData.setFont(fontbold);
			pSkillData.add(table);
			pSkillData.setIndentationLeft(150f);
			

			document.add(pSkillData);

		}

		document.add(Chunk.NEWLINE);
		document.add(Chunk.NEWLINE);
		
		if(recognitions.size()!= 0)
		{

		Paragraph pOther = new Paragraph("Other ", fontbold);
		pOther.setIndentationLeft(150f);
		document.add(pOther);

		Paragraph pCertification = new Paragraph("Certification/Training ",
				fontbold);
		pCertification.setIndentationLeft(150f);
		document.add(pCertification);

		for (RecognitionInfoVO recognition : recognitions) {
			if (recognition.getRecognitionType().getRecognitionTypeId() == 2
					|| recognition.getRecognitionType().getRecognitionTypeId() == 3) {
				Paragraph pCertificationTraining = new Paragraph(
						recognition.getItems(), font);
				pCertificationTraining.setIndentationLeft(150f);
				document.add(pCertificationTraining);

			}

		}

		document.add(Chunk.NEWLINE);

		Paragraph pAwardHeader = new Paragraph("Awards ", fontbold);
		pAwardHeader.setIndentationLeft(150f);
		document.add(pAwardHeader);

		for (RecognitionInfoVO recognition : recognitions) {
			if (recognition.getRecognitionType().getRecognitionTypeId() == 1) {
				Paragraph pAward = new Paragraph(recognition.getItems(), font);
				pAward.setIndentationLeft(150f);
				document.add(pAward);

			}

		}
		}

		// step 5
		document.close();

		return baosPDF;
	}

}
