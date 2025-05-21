package com.mycompany.demo.listeners;

import com.mycompany.demo.models.GenericModel;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MongoListener extends AbstractMongoEventListener<GenericModel> {
  @Override
  public void onBeforeConvert(BeforeConvertEvent<GenericModel> event) {
    super.onBeforeConvert(event);

    Date dateNow = new Date();

    event.getSource().setCreatedAt(dateNow);
    event.getSource().setUpdatedAt(dateNow);
  }
}
