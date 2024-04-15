package com.keyin.bstsprint;

import com.keyin.bstsprint.model.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@SpringBootTest
class BstSprintApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testInsertDuplicates() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(4);  // Attempt to insert a duplicate
        bst.insert(12);

        String expectedJson = "{\n" +
                "  \"value\": 7,\n" +
                "  \"left\": {\n" +
                "    \"value\": 4,\n" +
                "    \"left\": {},\n" +
                "    \"right\": {}\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"value\": 12,\n" +
                "    \"left\": {},\n" +
                "    \"right\": {}\n" +
                "  }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode expected = mapper.readTree(expectedJson);
        JsonNode actual = mapper.readTree(bst.toJson());

        assertEquals(expected, actual, "Tree structure should not include duplicate values.");
    }

    @Test
    void testToJson() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);

        String expectedJson = "{\n" +
                "  \"value\": 8,\n" +
                "  \"left\": {\n" +
                "    \"value\": 3,\n" +
                "    \"left\": {\n" +
                "      \"value\": 1,\n" +
                "      \"left\": {},\n" +
                "      \"right\": {}\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "      \"value\": 6,\n" +
                "      \"left\": {},\n" +
                "      \"right\": {}\n" +
                "    }\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"value\": 10,\n" +
                "    \"left\": {},\n" +
                "    \"right\": {}\n" +
                "  }\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode expected = mapper.readTree(expectedJson);
        JsonNode actual = mapper.readTree(bst.toJson());

        assertEquals(expected, actual, "JSON output should match expected structure");
    }

    @Test
    void testEmptyTreeToJson() {
        BinarySearchTree bst = new BinarySearchTree();
        assertEquals("{}", bst.toJson(), "Empty tree should return {}");
    }
}
