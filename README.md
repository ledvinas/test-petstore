#Positive test
Given User has pet added to the store

When user retreves pet from store

Then user can see that the pet has been inserted with correct values

#Negative test
Given user tires to insert pet with incorrect status of pet

When user tries to retreve pet by id

Then user shuld receve 404 pet not found

#Security test
Given user tries to insert pet to store that contains SQL-Injection strings

When user retreves the inserted pet

Then user shuld see that the filed contains sql query as string
