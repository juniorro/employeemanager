package com.getarrays.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static org.springframework.http.MediaType.parseMediaType;

@RestController
@RequestMapping("/file")
public class EmployeeResource {

	public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") List<MultipartFile> multipartFiles) throws IOException {
		List<String> fileNames = new ArrayList<>();
		for (MultipartFile multipartFile : multipartFiles) {
			String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
			copy(multipartFile.getInputStream(), fileStorage, REPLACE_EXISTING);
			fileNames.add(filename);
			}
		return ResponseEntity.ok().body(fileNames);
	}

	@GetMapping("/download/{filename}") //:.+
	public ResponseEntity<Resource> downloadFile(@PathVariable("filename") String filename) throws IOException {
		Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
		if (!Files.exists(filePath)) {
			throw new FileNotFoundException(filename + " was not found on the server");
		}
		Resource resource = new UrlResource(filePath.toUri());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("File-Name", filename);
		httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
		return ResponseEntity.ok().contentType(parseMediaType(Files.probeContentType(filePath)))
				.headers(httpHeaders).body(resource);
	}
}
