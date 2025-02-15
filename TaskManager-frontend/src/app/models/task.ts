import { Departament } from "./departament";
import { Person } from "./person";

export interface Task {
    id: number;
    title: string;
    description: string;
    duration: Date;
    deadline: Date;
    personAllocated: Person;
    departament: Departament;
    finalized: boolean;
}