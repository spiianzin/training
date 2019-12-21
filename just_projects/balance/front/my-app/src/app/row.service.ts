import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs'
import { MessageService } from './message.service';
import { ROWS } from './mock-balance-rows'
import { Row } from './row'

@Injectable({
  providedIn: 'root'
})
export class RowService {

  constructor(private messageService: MessageService) { }

  getRows(): Observable<Row[]> {
    this.messageService.add('RowService: fetched rows');
    return of(ROWS);
  }
}
