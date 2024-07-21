package com.example.ch6;

import java.util.Optional;

public class CreatingOptional {
    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.empty();
        System.out.println("Empty Optional::"+optionalUser.isPresent());

        User user=null;
        Optional<User> optionalUser1 = Optional.of(new User("Akshay"));
        System.out.println("Akshay Optional:"+optionalUser1.isPresent());


        Optional<User> optionalUser2 = Optional.ofNullable(user);
        System.out.println("null Optional ::"+optionalUser2.isPresent());

    }
}
