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

  getRow(uuid2: string): Observable<Row> {
    // TODO: send the message _after_ fetching the hero
    this.messageService.add(`RowService: fetched row uuid2=${uuid2}`);
    return of(ROWS.find(row => row.uuid2 === uuid2));
  }
}
