package com.example;

import java.util.Random;

public class JokeClassLib {

    private static final String[] jokes = {
            "Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
            "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "What could be a computer’s favorite dance item? Disk – o!",
            "How can you make number seven to an even number? Just take the “s” out from it! ",
            "Which is the flower on face? Tu – lips! ",
            "Can you name a bear with no socks? A bare-foot! lol :D ",
            "What type of waves are there in small beaches? Microwaves! Hehehe",
            "Employer : We need someone for this Job, who is Responsible.Applicant : Sir, your search ends here, in my previous job, whenever anything went wrong, they said I am Responsible..."
    };

    public static String getJoke(){
        int size = jokes.length;

        Random r = new Random();
        int index = r.nextInt(size);

        return jokes[index];
    }


}
