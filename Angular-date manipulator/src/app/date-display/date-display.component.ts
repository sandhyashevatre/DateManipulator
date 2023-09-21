import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-date-display',
  templateUrl: './date-display.component.html',
  styleUrls: ['./date-display.component.css']
})
export class DateDisplayComponent {
  selectedDate: string = '';
  submitted: boolean = false;
  specialDays: { date: string; description: string }[] = [
    { date: '2023-08-14', description: 'My birthday' },
    { date: '2023-09-10', description: 'Ganesh Utsav' },
    { date: '2023-10-27', description: 'Diwali' },
    { date: '2023-09-25', description: 'project start'},

    
  ];

  onSubmit() {
    this.submitted = true;
  }

  showNextDate() {
    if (this.selectedDate) {
      const currentDate = new Date(this.selectedDate);
      currentDate.setDate(currentDate.getDate() + 1);//increments date by one day
      this.selectedDate = currentDate.toISOString().split('T')[0];//ISO 8601 is a standardized (YYYY-MM-DDTHH:mm:ss.sssZ),[0]=end retrieves the first part of the split string
    }
  }

  showPreviousDate() {
    if (this.selectedDate) {
      const currentDate = new Date(this.selectedDate);
      currentDate.setDate(currentDate.getDate() - 1);
      this.selectedDate = currentDate.toISOString().split('T')[0];
    }
  }

  isSpecialDay(date: string): boolean { //checks if a given date is a special day, takes a date string as an argument
    return this.specialDays.some(specialDay => specialDay.date === date);// some() method to iterate through the specialDays array & checks if any of the special days have a date property that matches the provided date
  }

  getSpecialDayDescription(date: string): string | undefined {//retrieve the description of a special day
    const specialDay = this.specialDays.find(special => special.date === date);
    return specialDay ? specialDay.description : undefined;
  }
}

