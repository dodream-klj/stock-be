package com.soongsil.klj.stockbe.api;

import com.soongsil.klj.stockbe.dto.UserDto;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Deprecated
@RestController
@RequestMapping("/users")
public class UserApi {

  private final Map<Long, UserDto> users = new HashMap<>();

  @PostMapping
  public String createUser(@RequestBody @Valid UserDto userDto) {
    users.put(userDto.getId(), userDto);
    return "User created successfully: " + userDto.getUserName();
  }

  @GetMapping("/{id}")
  public UserDto getUser(@PathVariable Long id) {
    return users.get(id);
  }

  @GetMapping
  public List<UserDto> getAllUsers() {
    return new ArrayList<>(users.values());
  }

  @PutMapping("/{id}")
  public String updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
    if (users.containsKey(id)) {
      users.put(id, userDto);
      return "User updated successfully: " + id;
    } else {
      return "User not found: " + id;
    }
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    if (users.containsKey(id)) {
      users.remove(id);
      return "User deleted successfully: " + id;
    } else {
      return "User not found: " + id;
    }
  }
}