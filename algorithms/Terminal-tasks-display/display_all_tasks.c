#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/moduleparam.h>
#include <linux/sched.h>
#include <asm/uaccess.h>
#include <linux/init.h>
#include <linux/tty.h>
#include <linux/version.h>
#include <linux/sched/signal.h>

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Thiago");
MODULE_DESCRIPTION("Display all tasks in terminal.");
MODULE_VERSION("0.2");

struct task_struct *task_list;

static void print_string(char *message){ //Function to print on current terminal

	struct tty_struct *my_tty; //Terminal struct

	my_tty = get_current_tty(); // Get current Terminal
//my_tty->driver->ops->write Is how to write on terminal. 
	if(my_tty != NULL){
		(my_tty->driver->ops->write) (my_tty,"\015\012",2); //New line, octal for \r\n
		(my_tty->driver->ops->write) (my_tty,message,strlen(message));// Write message on current terminal
		(my_tty->driver->ops->write) (my_tty,"\015\012",2);
	}
}

static int __init print_string_init(void){ //Initial function that runs when the module is loaded

	printk(KERN_INFO "Displaying all tasks\n");// Prints this message on dmesg
	for_each_process(task_list){ // For each process running
		print_string(task_list->comm); //Display task name.
	}

	return 0;
}

static void __exit print_string_exit(void){ //Run this function when the module is unloaded
	printk(KERN_INFO "End\n");
}

module_init(print_string_init);  //Call function on module init
module_exit(print_string_exit); //Call function on module exit