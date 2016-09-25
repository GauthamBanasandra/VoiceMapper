package FeatureVector;

/**
 * Created by gauth_000 on 25-Sep-16.
 */
public class MfccVector
{
    private String filePath;
    private float[] mfcc;

    public MfccVector(String filePath, float[] mfcc)
    {
        this.filePath = filePath;
        this.mfcc = mfcc;
    }

    public String getFilePath()
    {
        return filePath;
    }

    public void setFilePath(String filePath)
    {
        this.filePath = filePath;
    }

    public float[] getMfcc()
    {
        return mfcc;
    }

    public void setMfcc(float[] mfcc)
    {
        this.mfcc = mfcc;
    }
}
