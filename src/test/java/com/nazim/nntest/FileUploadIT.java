//package com.nazim.nntest;
//
//import com.nazim.nntest.infrastructure.adapter.InputAdapter;
//import com.nazim.nntest.infrastructure.api.model.OkResponse;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.BDDAssertions.then;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class FileUploadIT {
//
//    @MockBean
//    private InputAdapter inputAdapter;
//
//    @Test
//    @DisplayName("testNewAuthorCreation")
//    void testNewAuthorCreation() {
//        new FileInputDriver(inputAdapter)
//        .whenNewFileUploaded("")
//                .thenFileStored(new OkResponse());
//    }
//
//    @RequiredArgsConstructor
//    public class FileInputDriver {
//
//        private final InputAdapter inputAdapter;
//        private OkResponse newOkResponse;
//
//        public FileInputDriver whenNewFileUploaded(String fileName) {
//            newOkResponse = inputAdapter.consumeUploadedFile(fileName);
//            return this;
//        }
//
//        public FileInputDriver thenFileStored(OkResponse response) {
//            then(response.getMessage());
//            return this;
//        }
//    }
//}
