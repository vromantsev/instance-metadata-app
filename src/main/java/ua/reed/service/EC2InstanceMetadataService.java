package ua.reed.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.imds.Ec2MetadataClient;
import software.amazon.awssdk.imds.Ec2MetadataResponse;

@Service
public class EC2InstanceMetadataService implements InstanceMetadataService {

    @Value("${aws.ec2.instance-metadata}")
    private String ec2InstanceMetadataEndpoint;

    private final Ec2MetadataClient ec2MetadataClient;

    public EC2InstanceMetadataService(Ec2MetadataClient ec2MetadataClient) {
        this.ec2MetadataClient = ec2MetadataClient;
    }

    @Override
    public Ec2MetadataResponse getInstanceMetadata() {
        return this.ec2MetadataClient.get(ec2InstanceMetadataEndpoint);
    }

    @Override
    public String getInstanceMetadataTag(final String tagId) {
        return this.ec2MetadataClient.get(ec2InstanceMetadataEndpoint.concat(tagId)).asString();
    }
}
