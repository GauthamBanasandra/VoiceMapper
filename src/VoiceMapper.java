import FeatureVector.FeatureVectorBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Created by gauth_000 on 15-Aug-16.
 */
public class VoiceMapper
{
    private FeatureVectorBuilder vectorBuilder;
    private File tempDir;

    public VoiceMapper()
    {
        this.vectorBuilder = new FeatureVectorBuilder();

        // Creating a directory for temporary use.
        this.tempDir = new File("temp");
        if (!this.tempDir.exists())
            try
            {
                if (!this.tempDir.mkdir())
                    throw new SecurityException();
            } catch (SecurityException e)
            {
                System.err.println("Security exception: Unable to create temp directory.");
                System.exit(1);
            }
    }

    private String[] extract_MFCC(String[] inputFilePaths, String frontEndMode) throws IOException
    {
        String[] outputFilePaths = new String[inputFilePaths.length];
        for (int i = 0; i < inputFilePaths.length; ++i)
        {
            String[] paths = inputFilePaths[i].split("\\\\");
            String outputFileName = this.tempDir.getAbsolutePath() + "\\" + paths[paths.length - 1] + ".txt";

            // Dump the feature vector into the temp directory
            this.vectorBuilder.dump_feature_vector(inputFilePaths[i], outputFileName, frontEndMode);

            outputFilePaths[i] = outputFileName;
        }

        return outputFilePaths;
    }

    private HashMap<String, double[]> generate_MFCC(String[] inputFilePaths, String frontEndMode) throws IOException
    {
        String[] tempFiles = extract_MFCC(inputFilePaths, frontEndMode);
        HashMap<String, double[]> mfccDict = new HashMap<String, double[]>(tempFiles.length);
        for (String tempFile : tempFiles)
        {
            String content = new String(Files.readAllBytes(Paths.get(tempFile)), StandardCharsets.UTF_8);
            String[] dataStr=content.split(" ");
            mfccDict.put(tempFile, to_double(dataStr));
        }

        return mfccDict;
    }

    private double[] to_double(String[] dataStr)
    {
        double[] data=new double[dataStr.length];
        for (int i = 0; i < dataStr.length; i++)
            data[i]=Double.parseDouble(dataStr[i]);

        return data;
    }

    public static void main(String[] args) throws IOException
    {
        /*FeatureVectorBuilder builder = new FeatureVectorBuilder();

        builder.dump_feature_vector("C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Hello world\\sample4.m4a",
                "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Hello world\\sample4.txt",
                "cepstraFrontEnd");
*/
        VoiceMapper voiceMapper = new VoiceMapper();
        String[] files = new String[2];
        files[0] = "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Hello world\\sample4.m4a";
        files[1] = "C:\\Users\\gauth_000\\Documents\\Projects\\VoiceMapper\\Voice samples\\Hello world\\sample1.m4a";
        System.out.println(voiceMapper.generate_MFCC(files, "cepstraFrontEnd"));
    }
}
