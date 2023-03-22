## Mockito

Documentation: https://site.mockito.org/

### Why do you need mocks?

-	Sometimes it is just difficult to test a component, because it depends on other components which are not available
-	In general, while unit testing, you should focus on testing and don’t care about if other components work properly
-	You want to avoid side effects of making actual calls. e.g. Any modification in database
-   Mocks are fake Java classes that replace these external dependencies. These fake classes are then instructed before the test starts to behave as you expect.

### Mock
- They are nothing but dummy objects instead of the real one.
- They are pre-programmed with expectations which form a specification of the calls they are expected to receive.
- They can throw an exception if they receive a call they don't expect and are checked during verification to ensure they got all the calls they were expecting.
- We can configure/override the behaviour of any method.

Example: If you want to inject CustomerRepository as a mock to your CustomerServiceTest, because you don't want to call the actual repository:

```
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService service;


}
```

## Stub

- Stubs provide fake answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test.
- When stubbing a method, you don’t care if and how many times the method is going to be called; you just want it to return some value, or perform some side effect, whenever it gets called.
- Even though stubbing and mocking are two different things, Mockito uses "mocks" for everything. But this terminology may change based on test framework you use. The syntax `when(something).thenReturn(somethingElse)` is actually called stubbing.

```
 @ExtendWith(MockitoExtension.class)
 public class CustomerReaderTest {

        @InjectMocks
        private CustomerReader customerReader;

        @Mock
        private EntityManager entityManager;


        @Test
        public void happyPathScenario(){
            Customer sampleCustomer = new Customer();
            sampleCustomer.setFirstName("Aditi");
            sampleCustomer.setLastName("Phadke");

            when(entityManager.find(Customer.class,1L)).thenReturn(sampleCustomer);

            String fullName = customerReader.findFullName(1L);
            assertEquals("Aditi Phadke",fullName);
        }
```

## Spy

- By default, all the methods called on a spy are going to be called on real objects. But some of the behaviour of a spy could be mocked (stubbed) if needed.
- You can verify or track interactions with a spy.

```
@Spy
private CustomerDaoImpl daoSpy;
verify(daoSpy).save(any(Customer.class));
```

### Exercise 1
1. Add dependencies to the project. You need: junit-jupiter-api, mockito-junit-jupiter, mockito-core.
2. Look at the structure of the project. Imagine that all the components that you have in `external` package are the one relying on some external service.

You have following tasks to accomplish:
3. Finish the implementation of `WareHouse`
4. Write one or more test cases for the `WareHouse` with following requirements:
- Use Mock dependencies as needed.
- Create a list of 3 products in your test and use it to test `processProducts` method.
- Test if `GSTCalculator` is called 3 times.
- Test if `productRepository` is called with right method parameters
- Test if `EmailService` is called with right parameters

### Exercise 2

1. Finish the implementation of `SmartDictionary`.
2. Write unit tests for `SmartDictionary`. Include tests for the exception handling.
3. Write one test that uses a captor to verify the TranslationResult save in history is correct.
4. Add the following business rule: TranslationResults retrieved from history that are older than 1 hour are no longer valid.
The should be removed from history and a new lookup using the Translator is required.
Update the test and write additional unit tests.
