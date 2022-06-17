# ASD -- Addepar Service Discovery

---
# WARNING
# THIS IS A WORK IN PROGRESS. NOT READY FOR PRIME TIME.

---

## Overview

ASD uses AWS Parameter Store (APS) to allow Arcade services to register their availability, un-register and find services. APS functions like a key/value store where the key is handled like a directory tree. For example the key

```/top/fruit/apple/config.json``` 

is the path to the config file for apple while the key

```/top/fruit/pear/config.json```

is the path to the config file for pear. Both are related because they are the "child" of the "parent" /top/fruit but separate entities. ASD uses a this model to store key/value pairs. APS refers to the key as a Parameter. ASD composes the key using 

 * Account ID -- the AWS account ID
 * Client Name -- The name of the client
 * Arcade Name -- The arcade name
 * Service Name -- the service name


For the purposes of this document  we are using the following data;

* Account ID -- 123456789012
 * Client Name -- big_client
 * Arcade Name -- big_pink.arc
 * Service Name -- iverson
 

This yields a key thus

```/ASD/123456789012/big_client/big_pink.arc/iverson/service_status.json```

The value that APS returns is, by default, a string. This could be anything but ASD encodes this as a json string like so

```
{
"account_id": "123456789",
"client_name": "big_client",
"arcade_name": "big_pink.arc",
"service_name": "iverson",
"service_status": "live",
"connection_string":"http://bin-pink.arc/iversion:8080"
}
```

From which the connection string is extracted. 

---
## Using ASD

The first step to register, un-register, or locate a Parameter Value (key/value pair) is to istantiante a ServiceMessage object. A Service Message can be created by one of  methods

 * ServiceMessage sm = new ServiceMessage();
 * ServiceMessage sm = new ServiceMessage(ServiceMessage);
 * ServiceMessage sm = new ServiceMessage(JSONObject);
 * ServiceMessage sm = new ServiceMessage(acc_id, client_name, arcade_name, service_name, service_state);


---
### Example one
 * Demos how to use a ServiceMessage object


 ### Example Two
 * Demos how to register a service.


### Example Three
 * Demos how to register multiple services


### Example Four
 * Demos how to retrieve the stored values per key

### Example Five
 * Demos how to retrieve multiple values

### Example Six
  * Demos how to retrieve multiple values with a defined filter

###  Example Seven
 * Demos how to search for a specific key(s) 

### Example Eight
 * Demos how to delete a key

