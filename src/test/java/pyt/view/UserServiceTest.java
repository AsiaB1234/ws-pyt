package pyt.view;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pyt.exception.PytServiceException;
import pyt.model.User;
import pyt.repository.UserRepository;
import pyt.service.AuthService;
import pyt.service.UserService;
import static org.mockito.Mockito.*;
import pyt.exception.UnauthorizedException;
import pyt.model.Project;
import pyt.model.Task;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private AuthService authServiceMock;

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;

    private String testUserPassword = "testP@ssword";
    private User testUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        testUser = getUser();
        doReturn(testUser).when(userRepositoryMock).findUserByEmail(testUser.getEmail());
        doReturn(testUser).when(userRepositoryMock).findOne(testUser.getId());
        doReturn(testUser).when(userRepositoryMock).findOne(eq(testUser.getId()), anyInt());
        doAnswer(anw -> anw.getArgumentAt(0, User.class)).when(userRepositoryMock).save(any(User.class));
    }

    @Test
    public void testGetById() {
        doReturn(testUser.getId()).when(authServiceMock).getCurrentLoggerUserId();

        UserView userFromRepository = userService.getUser();

        assertEquals(testUser.getId(), userFromRepository.getId());
        assertEquals(testUser.getName(), userFromRepository.getName());
        assertEquals(testUser.getCategories(), userFromRepository.getCategories());
        assertEquals(testUser.getProjects(), userFromRepository.getProjects());
        assertEquals(testUser.getTasks(), userFromRepository.getTasks());
    }

    @Test
    public void testLoginProperPassword() {
        User loggedUser = userService.login(testUser.getEmail(), testUserPassword);

        assertEquals(testUser, loggedUser);
    }

    @Test(expected = UnauthorizedException.class)
    public void testLoginBadPassword() {
        userService.login(testUser.getEmail(), "xxxx");
    }

    @Test(expected = PytServiceException.class)
    public void testLoginBadUser() {
        userService.login("bademail", "xxxx");
    }

    @Test(expected = PytServiceException.class)
    public void testSignUpUserAlreadyExists() {
        SignUpRequest request = new SignUpRequest();
        request.setEmail(testUser.getEmail());
        userService.signUp(request);
    }

    @Test
    public void testSignUp() {
        SignUpRequest request = new SignUpRequest();
        request.setEmail("test2@email.com");
        request.setName("test user 2");
        request.setPassword("test password");
        User newUser = userService.signUp(request);
        assertNotNull(newUser);
        assertEquals(request.getEmail(), newUser.getEmail());
        assertEquals(request.getName(), newUser.getName());
        assertEquals(userService.hashPassword(request.getPassword()), newUser.getPassword());
    }

    @Test(expected = PytServiceException.class)
    public void testAddTaskUserNotExist() {
        userService.addTask(null);
    }

    @Test
    public void testAddTask() {
        doReturn(testUser.getId()).when(authServiceMock).getCurrentLoggerUserId();

        Task task = new Task(1234l, "Test task", null, null, null, null, null, null);
        Task newTask = userService.addTask(task);

        assertEquals(task, newTask);
        assertTrue(testUser.getTasks().contains(task));
    }

    @Test(expected = PytServiceException.class)
    public void testAddProjectUserNotExist() {
        userService.addProject(null);
    }

    @Test
    public void testAddProject() {
        doReturn(testUser.getId()).when(authServiceMock).getCurrentLoggerUserId();

        Project project = new Project(1234l, "Test task", null);
        Project newProject = userService.addProject(project);

        assertEquals(project, newProject);
        assertTrue(testUser.getProjects().contains(project));
    }

    private User getUser() {
        return new User(123l, "test user", userService.hashPassword(testUserPassword), "test@email.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

}
