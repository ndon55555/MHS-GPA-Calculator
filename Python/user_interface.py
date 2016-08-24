import tkinter as tk
import classroom


def calculate_gpa():
    filepath = filepath_entry.get()

    try:
        transcript = open(filepath)
    except FileNotFoundError:
        gpa_label.config(fg='red', text="File does not exist.")
        return

    classrooms = []

    try:
        for line in transcript.read().splitlines():
            info = line.split()
            info_last_index = len(info) - 1
            name_pieces = info[3:info_last_index - 6]
            name_pieces_last_index = len(name_pieces) - 1

            if ',' in name_pieces[name_pieces_last_index]:
                string_length = len(name_pieces[name_pieces_last_index])
                name_pieces[name_pieces_last_index] = name_pieces[name_pieces_last_index][:string_length - 1]

            name = name_pieces[0]

            for index in range(1, len(name_pieces)):
                name += ' ' + name_pieces[index]

            level = int(info[info_last_index - 5])
            score = int(info[info_last_index - 2])
            weight = float(info[info_last_index])
            current_classroom = classroom.Classroom(name, level, score, weight)
            classrooms.append(current_classroom)

        total_gpa = 0.0
        total_weight = 0.0

        for current_classroom in classrooms:
            total_gpa += current_classroom.get_weighted_gpa()
            total_weight += current_classroom.weight

        gpa = round(total_gpa / total_weight * 1000) / 1000
        gpa_label.config(fg='black', text="GPA: " + str(gpa))
    except Exception:
        gpa_label.config(fg='red', text="Something is wrong with the formatting of the transcript.\nContact Don Nguyen if needed.")


root = tk.Tk()
root.geometry("400x200")
root.resizable(width=False, height=False)

greeting = "Welcome to the MHS Weighted GPA Calculator!"
greeting_label = tk.Label(master=root, text=greeting, font='-weight bold')
greeting_label.pack(side=tk.TOP)

filepath_prompt = "Enter file path of transcript file:"
filepath_prompt_label = tk.Label(master=root, text=filepath_prompt)
filepath_prompt_label.place(x=25, y=50)
filepath_entry = tk.Entry(master=root)
filepath_entry.place(x=200, y=50)

calculate_button = tk.Button(master=root, text="Calculate GPA", command=calculate_gpa)
calculate_button.place(x=25, y=150)

gpa_label = tk.Label(master=root, text="GPA:")
gpa_label.place(x=25, y = 100)

close_window_button = tk.Button(master=root, text="Close", command=root.destroy)
close_window_button.place(x=325, y=150)

root.mainloop()
#
