package com.stickynote.algorithm;

import java.util.List;

import org.springframework.stereotype.Component;

import com.stickynote.model.NoteUserDTO;

@Component
public class NoteUserQuickSortIncre extends QuickSort<NoteUserDTO> {

	@Override
	protected int partition(List<NoteUserDTO> ls, int begin, int end) {
		NoteUserDTO pivot = ls.get(end);
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (ls.get(j).getCreatedate().compareTo(pivot.getCreatedate()) > 0) {
				i++;

				NoteUserDTO swapTemp = ls.get(i);
				ls.set(i, ls.get(j));
				ls.set(j, swapTemp);
			}
		}

		NoteUserDTO swapTemp = ls.get(i + 1);
		ls.set(i + 1, ls.get(end));
		ls.set(end, swapTemp);

		return i + 1;

	}

}
