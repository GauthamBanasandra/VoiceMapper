import FeatureVector.FeatureVectorBuilder;

import java.io.File;
import java.io.IOException;

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

    public String[] extract_MFCC(String[] inputFilePaths, String frontEndMode) throws IOException
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

    /*private MfccVector[] generate_MFCC(String[] inputFilePaths, String frontEndMode) throws IOException
    {
        String[] tempFiles = extract_MFCC(inputFilePaths, frontEndMode);
        MfccVector[] mfccVectorsList=new MfccVector[tempFiles.length];

        for (int i=0; i<mfccVectorsList.length; ++i)
        {
            String content = new String(Files.readAllBytes(Paths.get(tempFiles[i])), StandardCharsets.UTF_8);
            String[] dataStr=content.split(" ");
            mfccVectorsList[i]=new MfccVector(tempFiles[i], to_float(dataStr));
        }

        return mfccVectorsList;
    }
    private float[] to_float(String[] dataStr)
    {
        float[] data=new float[dataStr.length];
        for (int i = 0; i < dataStr.length; i++)
            data[i]=Float.parseFloat(dataStr[i]);

        return data;
    }
*/
    public static void main(String[] args) throws IOException
    {
        VoiceMapper voiceMapper = new VoiceMapper();
        String[] vectorFiles=voiceMapper.extract_MFCC(args, "cepstraFrontEnd");
        for (String filePath:vectorFiles)
            System.out.println(filePath);
    }
}
