/*
 * package com.revature.repository;
 * 
 * import org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.TestInstance; import
 * org.junit.jupiter.api.TestInstance.Lifecycle; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.MockitoAnnotations;
 * 
 * import com.revature.services.models.Account; import
 * com.revature.services.models.Transaction;
 * 
 * @TestInstance(Lifecycle.PER_CLASS) public class AccountDaoTest {
 * 
 * @Mock private AccountDaoInterface aDao;
 * 
 * 
 * @BeforeAll void setup() { MockitoAnnotations.openMocks(this); aDao =
 * (AccountDaoInterface) new Account(1, "saving",15600, "9/21/2022", false,
 * "768hy6678");
 * 
 * 
 * }
 * 
 * @Test public void selectAccountByIdTest() {
 * Mockito.when(aDao.selectAccountById(account_Id)).thenReturn(aDao);
 * 
 * }
 * 
 * }
 */
