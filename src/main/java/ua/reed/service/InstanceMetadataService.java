package ua.reed.service;

import software.amazon.awssdk.imds.Ec2MetadataResponse;

public interface InstanceMetadataService {

    Ec2MetadataResponse getInstanceMetadata();

    String getInstanceMetadataTag(final String tagId);

}
