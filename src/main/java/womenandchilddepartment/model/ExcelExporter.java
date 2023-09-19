package womenandchilddepartment.model;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import womenandchilddepartment.repo.AdvertisementRepo;
import womenandchilddepartment.repo.PostRepo;

@Service
public class PdfGenerationService {

    @Autowired
    private AdvertisementRepo advertisementRepo;

    @Autowired
    private PostRepo postRepo;

    public byte[] generatePdf() throws IOException {
        // Create a new PDF document
        PDDocument document = new PDDocument();

        // Create a page in the document
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        // Create a content stream for writing text
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Fetch data from the first table
        List<Advertisement> table1Data = advertisementRepo.findAll();
        for (Advertisement data : table1Data) {
            contentStream.showText("Table 1 Data: " + data.toString());
            contentStream.newLine();
        }

        // Fetch data from the second table
        List<Post> table2Data = postRepo.findAll();
        for (Post data : table2Data) {
            contentStream.showText("Table 2 Data: " + data.toString());
            contentStream.newLine();
        }

        // Close the content stream and save the document
        contentStream.close();
        byte[] pdfBytes = document.saveToByteArray();
        document.close();

        return pdfBytes;
    }
}
