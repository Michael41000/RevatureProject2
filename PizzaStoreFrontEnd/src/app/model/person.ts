import { location } from './location';
import { role } from './role';
import { pizza } from './pizza';

export class person {

    personId: number;
    firstName: string;
    lastName: string;
    username: string;
    password: string;
    location: location;
    role: role;
    favorites: pizza[];

    constructor(personId?: number, firstName?: string, lastName?: string, username?: string, password?: string, location?: location, role?: role, favorites?: pizza[]) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.role = role;
        this.favorites = favorites;
    }

}