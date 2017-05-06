import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.invocation.InvocationOnMock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.stubbing.Answer

import static org.junit.Assert.assertEquals
import static org.mockito.ArgumentMatchers.anyInt
import static org.mockito.ArgumentMatchers.eq
import static org.mockito.BDDMockito.given
import static org.mockito.BDDMockito.then
import static org.mockito.Mockito.atLeastOnce
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when


@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class CarTest {

    @Mock
    Car car;
    @Mock
    List mockedList;

    @Test
    public void buzz() throws Exception {
        when(car.buzz()).thenReturn("Mocked: Buzz---")
        assertEquals(car.buzz(), "Mocked: Buzz---")
        verify(car).buzz()
    }

    @Test
    public void buzzTestBDD() throws Exception {
        given(car.buzz()).willReturn("Mocked: Buzz---")
        assertEquals(car.buzz(), "Mocked: Buzz---")
        then(car).should().buzz();
    }

    @Test
    public void runAnswerTestBDD() throws Exception {
        given(car.run(anyInt())).willAnswer(new Answer() {
            Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments()
                Object mock = invocation.getMock()
                return "Just " + args[0] + " miles"
            }
        })
        assertEquals("Just 3 miles", car.run(3))
        then(car).should().run(3);
    }

    @Test
    public void listTest() throws Exception {
        mockedList.add(1,"Jacky")
        verify(mockedList).add(anyInt(), eq("Jacky"))
    }

}