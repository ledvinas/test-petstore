#Positive test<br/>
**Given** User has pet added to the store<br/>
**When** user retreves pet from store<br/>
**Then** user can see that the pet has been inserted with correct values<br/>
<br/>
#Negative test<br/>
**Given** user tires to insert pet with incorrect status of pet<br/>
**When** user tries to retreve pet by id<br/>
**Then** user shuld receve 404 pet not found<br/>
<br/>
#Security test<br/>
**Given** user tries to insert pet to store that contains SQL-Injection strings<br/> 
**When** user retreves the inserted pet<br/>
**Then** user shuld see that the filed contains sql query as string<br/>
<br/>
Execute tests using command: **mvn clean verify -Dtags="PetStore"**<br/>
<br/>
Report location:target/site/reports/index.html
